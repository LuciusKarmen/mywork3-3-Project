import { createBrowserRouter, Navigate } from 'react-router-dom';
import Main from '../view/Main';
import Login from '../view/Login';


// 使用 createBrowserRouter 配置路由
const router = createBrowserRouter([
  {
    path: '/',
    element: 
  },
  {
    path: '/login',
    element: <Login />,
  },
  {
    path: '/main',
    element: <Main/>,
    children: [
      { index: true, element: <div>欢迎进入主页面</div> },
      { path: 'dashboard', element: <div>仪表盘内容</div> },
      { path: 'users', element: <div>员工管理内容</div> },
      { path: 'settings', element: <div>设置内容</div> },
    ],
  },
  {
    path: '*',
    element: <div style={{ textAlign: 'center', marginTop: '100px' }}>页面不存在，请重新试试吧！</div>,
  },
]);

export default router;