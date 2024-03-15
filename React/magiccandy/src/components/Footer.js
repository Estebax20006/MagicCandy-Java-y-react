import React from 'react'
import '../assets/styles/Inicio.css'

function Footer() {
  return (
    <footer className="bg-light text-dark pt-5 pb-4" style={{ height: '1%' }}>
    <div className="container text-center text-md-start" style={{ marginTop: '-20px' }}>
      <div className="row text-center text-md-start">
        <div className="col-md-3 col-lg-3 col-xl-3 mx-auto mt-3">
          <h5 className="text-uppercase mb-4" style={{ color: '#009fe3', fontSize: '14px', fontWeight: 'bold' }}>
            Horario de atención
          </h5>
          <hr className="mb-4" />
          <p style={{ fontSize: '12px' }}>
            Lunes a Viernes
            <br />
            8 a.m. - 7 p.m.
            <br />
            <br />
            Sábado
            <br />
            9 a.m. - 5 p.m.
          </p>
        </div>
        <div className="col-md-2 col-lg-2 col-xl-2 mx-auto mt-2">
          <h5 className="text-uppercase mb-4" style={{ color: '#009fe3', fontSize: '14px', fontWeight: 'bold' }}>
            Contáctanos
          </h5>
          <hr className="mb-4" />
          <p style={{ fontSize: '12px' }}>
            <a href="Contacto.html" className="text-dark">
              Formulario para contactarnos
            </a>
          </p>
          <p style={{ fontSize: '12px' }}>
            <a href="error500.html" className="text-dark">
              Política de privacidad
            </a>
          </p>
          <p style={{ fontSize: '12px' }}>
            <a href="error404.html" className="text-dark">
              Conoce más...
            </a>
          </p>
        </div>
        <div className="col-md-3 col-lg-3 col-xl-3 mx-auto mt-3">
          <h5 className="text-uppercase mb-4" style={{ color: '#009fe3', fontSize: '14px', fontWeight: 'bold' }}>
            Nuestros datos
          </h5>
          <hr className="mb-4" />
          <p style={{ fontSize: '12px' }}>
            <i className="bi bi-house-fill">
              {' '}
              <a href="https://goo.gl/maps/WFHV">
                1234 Main St, Springfield, MA 01111
              </a>
            </i>
          </p>
          <p style={{ fontSize: '12px' }}>
            <i className="bi bi-phone-fill"> </i> +1 (123) 456-7890
          </p>
          <p style={{ fontSize: '12px' }}>
            <i className="bi bi-envelope-fill"> </i> info@magiccandys.com
          </p>
        </div>
      </div>
    </div>
    <hr className="mb-4" />
    <div className="text-center" style={{ fontSize: '12px' }}>
      <p>
        © 2023 Magic Candys. Todos los derechos reservados.
        <a href="error500.html" className="text-dark">
          Política de privacidad
        </a>
      </p>
    </div>
  </footer>
  )
}

export default Footer
