package service;


import entity.CameraManage;
import entity.CameraPersonAddInput;
import entity.CameraSubscribeInput;

import java.util.List;

public interface CameraApiService {
    List<String> serchPersonByPhoneNumber(CameraManage cameraManage, String phone);
    void addPerson(CameraManage cameraManage, CameraPersonAddInput cameraPersonAddInput);
    void deletePerson(CameraManage cameraManage, String personId);

    String cameraSubscribe(CameraManage cameraManage, CameraSubscribeInput cameraSubscribeInput);

    void cameraRefreshSubscribe(CameraManage cameraManage, String refreshTime, String createId);
}
