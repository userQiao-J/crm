// 菜单请求工具类的封装
import { getRequest } from "./api";

export const initMenu = (router, store) => {
  if (store.state.routes.length > 0) {
    //有菜单数据，不需要加载
    return;
  }
  getRequest("/system/config/getMenu").then(data => {
    if (data) {
      let fmtRoutes = formatRoutes(data);
      router.addRoutes(fmtRoutes);
      store.commit("initRoutes", fmtRoutes);
    }
  });
};

export const formatRoutes = routes => {
  let fmRoutes = [];
  routes.forEach(router => {
    let { path, component, name, meta, iconCls, children } = router;
    if (children && children instanceof Array) {
      children = formatRoutes(children);
    }
    let fmRouter = {
      path: path,
      name: name,
      iconCls: iconCls,
      meta: meta,
      children: children,
      component(resolve) {
        if (component.startsWith("Home")) {
          //根据组件名称获取到对应的项目目录
          require(["../views/" + component + ".vue"], resolve);
        }else if (component.startsWith("Sys")) {
          //根据组件名称获取到对应的项目目录
          require(["../views/sys/" + component + ".vue"], resolve);
        }
      }
    };
    fmRoutes.push(fmRouter);
  });
  return fmRoutes;
};
