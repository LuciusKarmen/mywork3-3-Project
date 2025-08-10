import { Link } from 'react-router-dom';

export default function Navbar() {
  return (
    <nav style={{ padding: '1rem', backgroundColor: '#d4d4d4ff',fontSize: '20px' }}>
      <Link to="/" style={{ margin: '0 10px' }}>首页</Link>
      <Link to="/about" style={{ margin: '0 10px' }}>关于</Link>
    </nav>
  );
}