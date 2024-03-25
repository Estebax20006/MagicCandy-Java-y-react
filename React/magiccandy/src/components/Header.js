import React from 'react'
import Logo from '../assets/img/Logo.webp'
import { NavLink } from 'react-router-dom';

function Header() {
  return (
    <>
    <header>
    <a href="Inicio.html"><img className="logo" src={Logo} alt="Logo" height="70px" width="200px" /></a>
    <input type="checkbox" id="check" />
    <label htmlFor="check" className="show-menu">&#8801;</label>
    <nav className="menu">
      <a><NavLink exact to = "/" activeClassName="active">Inicio</NavLink></a>
      <a><NavLink exact to = "/Nosotros" activeClassName="active">Nosotros</NavLink></a>
      <a href="Cuenta.html">Cuenta</a>
      {/*<a href="Inicio.html">Inicio</a> */}
      <a href="Productos.html">Productos</a>
      {/*<a href="Nosotros.html">Nosotros</a>*/}
      <a><NavLink exact to = "/Contacto" activeClassName="active">Contacto</NavLink></a>
      <a href="Carrito.html"><i className="fas fa-shopping-cart"></i></a>
      <label htmlFor="check" className="hide-menu">&#215;</label>
    </nav>
  </header>
  </>
  )
}

export default Header
