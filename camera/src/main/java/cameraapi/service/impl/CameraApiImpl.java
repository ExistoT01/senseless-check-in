
package cameraapi.service.impl;

import cameraapi.VO.GetFaceDatabaseIdVO;
import cameraapi.service.CameraApiService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.ouc.camera.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CameraApiImpl implements CameraApiService {


/*public static final MediaType JSON= MediaType.parse("application/json; charset=utf-8");

    //新建一个OkHttpClient对象
    OkHttpClient client = new OkHttpClient();


    public String SerachPeopleByID(int id)throws IOException {

        String url ="/LAPI/V1.0/PeopleLibraries/"+id+"/People/Info";


        //RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
               // .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }*/

    //@Autowired
    //private RestTemplate restTemplate;


//  @Autowired
//    private RedisUtil redisUtil;


   /* @Autowired
    private CameraApiService cameraApiService;*/

/**
     * 人脸信息查询--根据手机号查询
     */

    @Override
    public List<String> serchPersonByPhoneNumber(CameraManage cameraManage, String phone){
        String url = String.format("http://%s/LAPI/V1.0/PeopleLibraries/%s/People/Info", cameraManage.getIp(), cameraManage.getLibId());
        CameraGetPersonIdInput cameraGetPersonIdInput = new CameraGetPersonIdInput();
        List<CameraGetPersonIdInput.QueryInfosBean> queryInfosBeans = new ArrayList<>();
        CameraGetPersonIdInput.QueryInfosBean queryInfosBean = new CameraGetPersonIdInput.QueryInfosBean();
        queryInfosBean.setQryType(58);
        queryInfosBean.setQryCondition(0);
        queryInfosBean.setQryData(phone);
        queryInfosBeans.add(queryInfosBean);
        cameraGetPersonIdInput.setQueryInfos(queryInfosBeans);

        String jsonStr = JSONObject.toJSONString(cameraGetPersonIdInput);
        ResponseEntity<String> response = httpResponse(url, HttpMethod.POST, jsonStr);
        CameraPersonIdResponse res = JSON.parseObject(response.getBody(), CameraPersonIdResponse.class);
        //获取符合查询条件的总数
        List<String> personIds = new ArrayList<>();
        int total = res.getResponse().getData().getTotal();
        if (total > 0) {
            List<CameraPersonIdResponse.ResponseBean.DataBean.PersonListBean.PersonInfoListBean> PersonInfoList = res.getResponse().getData().getPersonList().getPersonInfoList();
            PersonInfoList.forEach(person -> {
                personIds.add(person.getPersonId());
            });
        }

        return personIds;

    }


/**
     * 新增人员
     * @param cameraManage
     * @param cameraPersonAddInput
     */

    @Override
    public void addPerson(CameraManage cameraManage, CameraPersonAddInput cameraPersonAddInput){
        //拼接请求地址
        String url = String.format("http://%s/LAPI/V1.0/PeopleLibraries/%s/People", cameraManage.getIp(), cameraManage.getLibId());
        //将实体类转换为jsonObject
        String json = JSONObject.toJSONString(cameraPersonAddInput);
        httpResponse(url, HttpMethod.POST, json);
    }


/**
     * 通过ID删除人员
     * @param cameraManage
     * @param personId
     */

    @Override
    public void deletePerson(CameraManage cameraManage, String personId) {
        String url = String.format("http://%s/LAPI/V1.0/PeopleLibraries/%s/People/%s", cameraManage.getIp(), cameraManage.getLibId(), personId);
        httpResponse(url, HttpMethod.DELETE, null);
    }


/**
     * 订阅
     * @param cameraManage
     * @param cameraSubscribeInput
     * @return
     */

    @Override
    public String cameraSubscribe(CameraManage cameraManage, CameraSubscribeInput cameraSubscribeInput) {

        String url = String.format("http://%s/LAPI/V1.0/System/Event/Subscription", cameraManage.getIp());
        //将入参封装为json
        String json = JSONObject.toJSONString(cameraSubscribeInput);
        ResponseEntity<String> response = httpResponse(url, HttpMethod.POST, json);
        CameraSubscribeResponse res = JSON.parseObject(response.getBody(), CameraSubscribeResponse.class);
        return res.getResponse().getCreatedId();
    }


/**
     * 刷新订阅
     * @param cameraManage
     * @param refreshTime
     * @param createId
     */

    @Override
    public void cameraRefreshSubscribe(CameraManage cameraManage, String refreshTime, String createId) {
        String url = String.format("http://%s/LAPI/V1.0/System/Event/Subscription/%s", cameraManage.getIp(), createId);
        //入参设置
        String param = "{\n" +
                " \"Duration\": Time\n" +
                "}";
        String json = param.replace("Time", refreshTime);
        ResponseEntity<String> response = httpResponse(url, HttpMethod.POST, json);
        CameraRefreshSubscribeResponse res = JSON.parseObject(response.getBody(), CameraRefreshSubscribeResponse.class);
        log.info(cameraManage.getIp()+": 订阅刷新状态"+res.getResponse().getResponseString());
        String createdId = res.getResponse().getCreatedId();
        //将刷新订阅id存入redis
        //redisUtil.hset(ConfigConstant.CAMERA_CREATEDID_REDIS_KEY, cameraManage.getIp(), createdId, 3500);
    }
    @Override
    public GetFaceDatabaseIdVO getFaceDatabaseId(CameraManage cameraManage) {

        //拼接请求地址
        String url = String.format("http://%s/LAPI/V1.0/PeopleLibraries/BasicInfo", cameraManage.getIp());
        ResponseEntity<String> response = httpResponse(url, HttpMethod.GET, null);
        CameraFaceDatabaseResponse res = JSON.parseObject(response.getBody(), CameraFaceDatabaseResponse.class);
        GetFaceDatabaseIdVO getFaceDatabaseIdVO = new GetFaceDatabaseIdVO();
        List<GetFaceDatabaseIdVO.libIdListBean> resLibIdList = new ArrayList<>();
        //获取符合查询条件的人脸库总数
        if (res.getResponse().getData().getNum() > 0) {

            List<CameraFaceDatabaseResponse.ResponseBean.DataBean.LibListBean> libList = res.getResponse().getData().getLibList();
            libList.forEach(person -> {

                GetFaceDatabaseIdVO.libIdListBean libIdListBean = new GetFaceDatabaseIdVO.libIdListBean();
                libIdListBean.setName(new String(person.getName().getBytes(StandardCharsets.ISO_8859_1)));
                libIdListBean.setLibId(person.getId());
                resLibIdList.add(libIdListBean);
            });
        } else {
            return getFaceDatabaseIdVO;
        }
        getFaceDatabaseIdVO.setLibIdList(resLibIdList);
        //构建返回参数集合遍历取人脸库name，id
        return getFaceDatabaseIdVO;
    }

    public ResponseEntity<String> httpResponse(String url, HttpMethod httpType, String jsonStr) {

        //创建请求头
        JSONObject jsonArray = JSON.parseObject(jsonStr);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<JSONObject> httpEntity = new HttpEntity<>(jsonArray, headers);
        ResponseEntity<String> response = null;
        //post请求获取返回体并转换json
        try {
           // response = restTemplate.exchange(url, httpType, httpEntity, String.class);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return response;
    }

}

