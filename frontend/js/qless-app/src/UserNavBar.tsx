import './UserNavBar.css'
import logo from './images/QL_1.png'

export function UserNavBar() {
    return (
        <nav className="myuserbar">
            <label className="hamburguer">Hamburguer Menu</label>
            <img src={logo} className='navqlesslogo' alt=""/>
            <label className="pfp">Profile Picture</label>
        </nav>
    )
}