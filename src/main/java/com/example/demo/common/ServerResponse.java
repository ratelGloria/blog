package com.example.demo.common;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.stereotype.Controller;

@Controller
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> {

        private static  Integer SUCCESS = 1;

        private static  Integer UNSUCCESS = 0;

        private Integer status;

        private String msg;

        private T data;

        private ServerResponse(){}

        private ServerResponse(Integer status){
            this.status = status;
        }

        private ServerResponse(Integer status,String msg){
            this.status = status;
            this.msg = msg;
        }
        private ServerResponse(Integer status,String msg,T data){
            this.status = status;
            this.msg = msg;
            this.data = data;
        }

        private ServerResponse(Integer status,T data){
            this.status = status;
            this.data = data;
        }

        public static<T> ServerResponse serverResponseSuccess(String msg,T data){

            return new ServerResponse(SUCCESS,msg,data);
        }

        public static<T> ServerResponse serverResponseSuccess(String msg){

            return new ServerResponse(SUCCESS,msg);
        }

        public static<T> ServerResponse serverResponseSuccess(T data){

            return new ServerResponse(SUCCESS,data);
        }

        public static<T> ServerResponse serverResponseSuccess(){

            return new ServerResponse(SUCCESS);
        }

        public static<T> ServerResponse serverResponseUnSuccess(String msg,T data){

            return new ServerResponse(UNSUCCESS,msg,data);
        }

        public static<T> ServerResponse serverResponseUnSuccess(String msg){

            return new ServerResponse(UNSUCCESS,msg);
        }

        public static<T> ServerResponse serverResponseUnSuccess(){

            return new ServerResponse(UNSUCCESS);
        }

        public static<T> ServerResponse serverResponseUnSuccess(T data){

            return new ServerResponse(UNSUCCESS,data);
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "ServerResponse{" +
                    "status=" + status +
                    ", msg='" + msg + '\'' +
                    ", data=" + data +
                    '}';
        }


}
