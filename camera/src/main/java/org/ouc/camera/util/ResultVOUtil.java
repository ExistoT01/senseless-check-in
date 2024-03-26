package org.ouc.camera.util;


import org.ouc.camera.vo.ResultVo;

public class ResultVOUtil {
    public static ResultVo success(Object object){
        ResultVo resultVo=new ResultVo();
        resultVo.setCode(0);
        resultVo.setData(object);
        return resultVo;
    }
    public static ResultVo fail(){
        ResultVo resultVo =new ResultVo() ;
        resultVo .setCode(-1);
        return resultVo;
    }
}
