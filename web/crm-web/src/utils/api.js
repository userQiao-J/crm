/**
 * 请求工具类
 * @author userqiao
 * */
import axios from "axios";
import { Message } from "element-ui/";

axios.interceptors.response.use(
  success => {
    if (success.status && success.status == 200 && success.data.status == 500) {
      Message.error(success.data.msg);
      return;
    }
    if (success.data.msg) {
      Message.success(success.data.msg)
    }
    return success.data;
  },
  error => {
    if (error.response.status == 504 || error.response.status == 404) {
      Message.error("访问不到服务器，请联系管理员");
    } else if (error.status == 403) {
      Message.error("权限不足，请联系管理员");
    } else if (error.status == 401) {
      Message.error("尚未登录，请登录");
    } else {
      if (error.response.data.msg) {
        Message.error(error.response.data.msg);
      } else {
        Message.error("未知错误");
      }
    }
    return;
  }
);

let base = "";

export const postKeyValueRequest = (url, params) => {
  return axios({
    method: "post",
    url: `${base}${url}`,
    data: params,
    transformRequest: [
      function(data) {
        let ret = "";
        for (let retKey in data) {
          ret +=
            encodeURIComponent(retKey) +
            "=" +
            encodeURIComponent(data[retKey]) +
            "&";
        }
        return ret;
      }
    ],
    header: {
      "Content-Type": "application/x-www.form-urlencoded"
    }
  });
};

//Post请求封装
export const postRequest = (url, params) => {
  return axios({
    method: "post",
    url: `${base}${url}`,
    data: params
  });
};

//Put请求封装
export const putRequest = (url, params) => {
  return axios({
    method: "put",
    url: `${base}${url}`,
    data: params
  });
};
export const getRequest = url => {
  return axios({
    method: "get",
    url: `${base}${url}`
  });
};

export const deleteRequest = url => {
  return axios({
    method: "delete",
    url: `${base}${url}`
  });
};
