import {Button} from 'antd'
import { useNavigate } from 'react-router-dom'
function Setting(){
    const navigate = useNavigate()
    const handleClick = () => { 
        navigate('/our')
    }
    return ( 
        <div className="setting"> 
            <Button type='primary' onClick={handleClick}>关于我们</Button>
        </div>
    )
}

export default Setting