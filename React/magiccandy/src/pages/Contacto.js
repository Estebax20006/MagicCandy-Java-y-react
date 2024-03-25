import React from 'react'
import Header from '../components/Header'
import Footer from '../components/Footer'


function Contacto() {
  return (
    <>
    
    <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossOrigin="anonymous"
     />

    <Header />    

    <section className="form_wrap" style={{ maxWidth: '100%' }}>
      <section className="cantact_info">
        <section className="info_title">
          <span className="fa fa-user-circle"></span>
          <h2>INFORMACIÓN<br />DE CONTACTO</h2>
        </section>
        <section className="info_items">
          <p><span className="fa fa-envelope" style={{ fontSize: '18px' }}></span> magicandy@gmail.com</p>
          <p><span className="fa fa-mobile" style={{ fontSize: '18px' }}></span> (+57) 313 3813154</p>
          <p><span className="fa fa-map-marker" style={{ fontSize: '18px' }}></span>&nbsp; Calle 59 Tunja, Boyacá</p>
        </section>
      </section>

      <form action="https://formsubmit.co/magicandy2023@gmail.com" method="post" className="form_contact">
        <h2>Envía tu mensaje</h2>
        <div className="user_info">
          {/* Campo de nombre */}
          <label htmlFor="names">Nombre:</label>
          <input type="text" name="Nombre" id="names" required pattern="[A-Za-z\s]+" title="Ingresa solo letras y espacios" style={{ fontFamily: 'sans-serif' }} />
          <span id="namesError" className="error-message"></span>

          {/* Campo de teléfono/celular */}
          <label htmlFor="phone">Teléfono / Celular:</label>
          <input type="text" name="Teléfono" id="phone" pattern="[0-9]+" title="Ingresa solo números" style={{ fontFamily: 'sans-serif' }} />
          <span id="phoneError" className="error-message"></span>

          {/* Campo de correo electrónico */}
          <label htmlFor="email">Correo electrónico:</label>
          <input type="email" name="Correo" id="email" required pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.(com|co)" title="Ingresa un correo válido (.com o .co)" style={{ fontFamily: 'sans-serif' }} />
          <span id="emailError" className="error-message"></span>

          {/* Campo de mensaje */}
          <label htmlFor="mensaje">Mensaje:</label>
          <textarea id="mensaje" name="mensaje" required style={{ fontFamily: 'sans-serif' }}></textarea>
          <span id="mensajeError" className="error-message"></span>

          {/* Botón de enviar mensaje */}
          <input type="submit" value="Enviar Mensaje" id="btnSend" />

          {/* Vuelve a redirigir a la página que se le ponga después de completar formulario */}
          <input type="hidden" name="_next" value="Contacto.html" />
          {/* Para evitar bots en el formulario */}
          <input type="hidden" name="_captcha" value="false" />
        </div>
      </form>
    </section>

    <Footer />

    </>
  )
}

export default Contacto
