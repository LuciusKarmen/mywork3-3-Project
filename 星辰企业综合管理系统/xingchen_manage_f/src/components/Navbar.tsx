import { Link } from 'react-router-dom';

export default function Navbar() {
  return (
    <nav style={{ padding: '1rem', backgroundColor: '#f0f0f0' }}>
      <Link to="/" style={{ margin: '0 10px' }}>首页</Link>
      <Link to="/about" style={{ margin: '0 10px' }}>关于我们</Link>
    </nav>
  );
}