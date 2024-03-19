import React from 'react'
import img from '../assets/img/MGCwhite.jpg'
import { Outlet, Link } from "react-router-dom";

function Header() {
  return (
    <>
    <header>
    <a href="Inicio.html"><img className="logo" src={img} alt="Logo" height="70px" width="200px" /></a>
    <input type="checkbox" id="check" />
    <label htmlFor="check" className="show-menu">&#8801;</label>
    <nav className="menu">
      <a Link to="/Cuentas">Cuenta</a>
      <a href="Inicio.html">Inicio</a>
      <a href="Productos.html">Productos</a>
      <a href="">Nosotros</a>
      <a href="Contacto.html">Contacto</a>
      <a href="Carrito.html"><i className="fas fa-shopping-cart"></i></a>
      <label htmlFor="check" className="hide-menu">&#215;</label>
    </nav>
  </header>
  </>
  )
}

export default Header
