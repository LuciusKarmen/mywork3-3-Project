import { createBrowserRouter} from 'react-router-dom';
import Main from '../view/Main';
import Login from '../view/Login';
import Face from '../view/Face';
import Home from '../pages/Home';
import Register from '../view/Register';
const router = createBrowserRouter([
  {
    path: '/',
    element: <Face/>
  },
  {
    path: '/login',
    element: <Login />,
  },
    {
    path: '/reg',
    element: <Register/>
  },
  {
    path: '/main',
    element: <Main/>,
    children: [
      { index: true, element: <Home/>},
      { path: 'list', element: },
      { path: 'setting', element: <div>员工管理内容</div> } 
    ],
  },
  {
    path: '*',
    element: <div style={{ textAlign: 'center', marginTop: '100px' }}>页面不存在，请重新试试吧！</div>,
  },
]);

export default router;