
package cameraapi.service;


import cameraapi.VO.GetFaceDatabaseIdVO;
import org.ouc.camera.entity.CameraManage;
import org.ouc.camera.entity.CameraPersonAddInput;
import org.ouc.camera.entity.CameraSubscribeInput;

import java.util.List;

public interface CameraApiService {
    List<String> serchPersonByPhoneNumber(CameraManage cameraManage, String phone);
    void addPerson(CameraManage cameraManage, CameraPersonAddInput cameraPersonAddInput);
    void deletePerson(CameraManage cameraManage, String personId);

    String cameraSubscribe(CameraManage cameraManage, CameraSubscribeInput cameraSubscribeInput);

    GetFaceDatabaseIdVO getFaceDatabaseId(CameraManage cameraManage);
    void cameraRefreshSubscribe(CameraManage cameraManage, String refreshTime, String createId);

}
