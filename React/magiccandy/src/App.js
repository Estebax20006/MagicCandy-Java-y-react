import Contacto from './pages/Contacto';
import Inicio from './pages/Inicio'
import Nosotros from './pages/Nosotros';
import {BrowserRouter as Router,Routes,Route} from 'react-router-dom';


function App() {
  return (
    <Router>
      <div className='App'>
        <Routes>
          <Route path='/' element={<Inicio/>}/>
          <Route path='/Nosotros' element={<Nosotros/>}/>
          <Route path='/Contacto' element={<Contacto/>}/>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
