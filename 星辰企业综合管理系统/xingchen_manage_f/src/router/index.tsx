import { createBrowserRouter} from 'react-router-dom';
import Main from '../view/Main';
import Login from '../view/Login';
import Face from '../view/Face';
import Register from '../view/Register';
import Home from '../pages/Home';
import List from '../pages/List';
import Branch from '../pages/Branch';
import Add from '../pages/Manage/add';
import Del from '../pages/Manage/del';
import Upd from '../pages/Manage/upd';
import Setting from '../pages/Setting';

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
      { path: 'branch', element: <Branch/>},
      { path: 'list', element: <List/>},
      { path: 'manage', 
        children: [
          { path: 'add', element: <Add/>},
          { path: 'update', element: <Upd/>},
          { path: 'delete', element: <Del/>}
        ]
      },
      { path: 'setting', element: <Setting/> } 
    ],
  },
  {
    path: '*',
    element: <div style={{ textAlign: 'center', marginTop: '100px' }}>页面不存在，请重新试试吧！</div>,
  },
]);

export default router;