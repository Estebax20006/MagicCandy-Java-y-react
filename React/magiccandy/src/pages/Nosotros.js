import React from 'react'
import Header from '../components/Header'
import Footer from '../components/Footer'
import '../assets/styles/Nosotros.css'
import Niña from '../assets/img/niña.jpg'

function Nosotros() {
  return (
    <>  
        {/**Link de Boostrap */}
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"></link>
        <Header />
        <div>
            <h1 className="us-title">Nosotros</h1>

            <div className="first-paragraph">
                <p className="us-paragraph">Somos una dulcería apasionada por endulzar
                    la vida de las personas a través de nuestros deliciosos productos.
                    Desde nuestros inicios, nos hemos dedicado a fabricar refrescos y
                    revender una amplia variedad de dulces, convirtiéndonos en un destino
                    irresistible para los amantes de los sabores dulces y refrescantes.<br /><br />
                    Nuestra historia está marcada por la pasión por la excelencia y la
                    búsqueda constante de la satisfacción de nuestros clientes.
                    Trabajamos arduamente para ofrecer productos de la más alta calidad,
                    seleccionando cuidadosamente los ingredientes y siguiendo rigurosos
                    estándares de producción.</p>

                <div className="us-img">
                    <img src={Niña} width="450px" height="300px" alt="Niña en la dulcería" />
                </div>
            </div>

            <div className="parent">
                <div className="div1">
                    <div className="mission"><h3><span>Misión</span></h3></div>
                    <p id="mission-paragraph">Nuestra dulcería se dedica a endulzar
                        la vida de nuestros clientes ofreciendo una amplia
                        variedad de dulces y refrescos de alta calidad.
                        Nuestro objetivo es convertirnos en el lugar preferido
                        para satisfacer los antojos dulces, brindando
                        experiencias únicas y sabores irresistibles.</p>
                </div>

                <div className="div2">
                    <div className="vision"><h3><span>Visión</span></h3></div>
                    <p id="vision-paragraph">Ser reconocidos como la dulcería líder
                        en la fabricación de refrescos y venta de dulces,
                        destacando por nuestra calidad, innovación y la
                        experiencia dulce que brindamos a nuestros clientes.
                        También nos impulsamos a superar constantemente nuestros
                        límites y elevar la experiencia dulce a nuevos niveles.
                        Nos enorgullece brindar momentos de felicidad y
                        satisfacción a nuestros clientes.</p>
                </div>
            </div>
        </div>
        <Footer />
        </>
  )
}

export default Nosotros
