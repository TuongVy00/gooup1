
import React, {useState, useEffect} from 'react';
import "../styles/login.css"
import {Form, Button} from 'react-bootstrap';
import ReCAPTCHA from "react-google-recaptcha";
import image from "F:/Baitap/gooup1/bai1-login/src/image/logo.png";

const Login = () => {
    const [verifed, setVerifed] = useState(false);
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [isTablet, setIsTablet] = useState(false);
    const [errorEmail, setErrorEmail] = useState('');
    const [errorPassword, setErrorPassword] = useState('');

    useEffect(() => {
        const handleResize = () => {
          setIsTablet(window.innerWidth <= 768);
        };
    
        handleResize();
    
        window.addEventListener('resize', handleResize);
    
        return () => {
          window.removeEventListener('resize', handleResize);
        };
      }, []);
    
      function onChange(value) {
        console.log("Captcha value:", value);
        setVerifed(true);
      }
    
      const handleLogin = (e) => {
        e.preventDefault();
        
        console.log('Email:', email);
        console.log('Password:', password);
    
        setErrorEmail('');
        setErrorPassword('');
    
        if (!email) {
          setErrorEmail('Không được bỏ trống!');
        }
    
        if (!password) {
          setErrorPassword('Không được bỏ trống!');
        }
      };

 return (
    <section className='sesion'>
        
        <div style={{textAlign:"center"}}>
            <img src={image}></img>     
        </div>

        <div className='container'>
        <div className='form1'>
            <div className='div1'>
                <h1>Đăng nhập</h1>
                <p>Đăng nhập tài khoản của bạn</p>
                <Form className='form2'>
                    <Form.Group className='group1'>
                        <Form.Label className='group2'>Email:</Form.Label>
                        <Form.Control type="email" 
                                        id="password"
                                        aria-describedby="emailHelp" 
                                        placeholder="Nhập email"
                                        value={email} onChange={(event)=>setEmail(event.target.value)}
                                        required
                                         />
                                         <span style={{ color: 'red' }}>{errorEmail}</span>
                    </Form.Group>
                    <Form.Group className='group1'>
                        <Form.Label className='group2'>Mật khẩu: </Form.Label>
                        <Form.Control type="password" 
                                        id="password"
                                        placeholder="Nhập mật khẩu"
                                        value={password} onChange={(event)=>setPassword(event.target.value)}
                                        required
                                        />
                                         <span style={{ color: 'red' }}>{errorPassword}</span>
                    </Form.Group>
                    
                    <br></br>
                    <div>
                        <ReCAPTCHA sitekey='6LenZZ8oAAAAAP7tZyr0OdPOHI-hrP5uG5VG156b'></ReCAPTCHA>
                    </div>
                    <Button type="submit" onClick = {handleLogin} className='button1'>Đăng nhập</Button>
                </Form>
            </div>
            <div className='div2'>
                <img src={image}></img>  
            </div>

        </div>
            
     </div>
    </section>
 )
}

export default Login;