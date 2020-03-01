import React, {Component} from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField'
import '../styles/login.css'

const axios = require('axios');


class Login extends Component {
    state = {
        username: '',
        password: '',
        name: '',
        email: '',
        description: '',
        city: '',
        elo: 0,
        pictureLink: '',
        year: '',
        weight: ''
    }

    loginButtonOnClick = (event) => {
        this.props.handleLogin({ id: 1 });
        return;
        const userData = {
            username: this.state.username,
            password: this.state.password
        }

        console.log(userData);
        event.preventDefault();
        console.log(this.props);
        axios.post('http://localhost:8080/api/user/login/', userData)
            .then((response) => {
                if (response.status === 200) {
                    console.log('login successful')
                    console.log('user id: ', response.headers.id)

                    this.props.handleLogin({ id: response.headers.id });
                }
                else {
                    console.log("wrong auth")
                }
            })
            .catch(function (error) {
                console.log({ error: error });
            });
        console.log("should run change");
        //this.props.handleLogin({ id: 1337 })

        /* TODO: send POST request to login controller API and if user 
           has successfully log on, notify App component */
    }

    registerButtonOnClick = (event) => {
        event.preventDefault();
        axios.post('http://localhost:8080/api/user/register/', this.state)
            .then(function (response) {
                console.log(response);
                if (response.status === 200) {
                    console.log("proper response");
                    this.setState({ username: '' });
                    this.setState({ password: '' });
                    this.setState({ name: '' });
                    this.setState({ email: '' });
                    this.setState({ description: '' });
                    this.setState({ city: '' });
                    this.setState({ pictureLink: '' });
                    this.setState({ year: '' });
                    this.setState({ weight: '' });
                }
                else {
                    console.log("invalid response");
                }
            })
            .catch(function (error) {
                console.log(error);
            });
        console.log(this.state);

        this.props.handleRegister();
    }
    usernameInputChangeHandler = (event) => {
        this.setState({ username: event.target.value })
    }

    passwordInputChangeHandler = (event) => {
        this.setState({ password: event.target.value })
    }

    emailInputChangeHandler = (event) => {
        this.setState({ email: event.target.value })
    }

    nameInputChangeHandler = (event) => {
        this.setState({ name: event.target.value })
    }
    descriptionInputChangeHandler = (event) => {
        this.setState({ description: event.target.value })
    }
    cityInputChangeHandler = (event) => {
        this.setState({ city: event.target.value })
    }
    pictureInputChangeHandler = (event) => {
        this.setState({ pictureLink: event.target.value })
    }
    yearInputChangeHandler = (event) => {
        this.setState({ year: event.target.value })
    }
    weightInputChangeHandler = (event) => {
        this.setState({ weight: event.target.value })
    }

    render() {

        return (!this.props.register ?

            <div className="loginWindow">

                <form onSubmit={this.loginButtonOnClick}>
                    <TextField className="loginField" id="outlined-basic" label="Login" variant="outlined"
                               onChange={this.usernameInputChangeHandler}></TextField>
                    <br></br>
                    <TextField className="loginField" id="outlined-basic" label="Password" type="password"
                               variant="outlined" onChange={this.passwordInputChangeHandler}></TextField>
                    <br></br>
                    <Button className="loginButton" type="submit" variant="contained" color="primary" >Log in</Button>
                    <Button className="loginButton" variant="contained" color="primary"
                            onClick={this.props.handleRegister}>Register</Button>
                </form>
                <br></br>

            </div>
                : <div className="loginWindow">
                <form onSubmit={this.registerButtonOnClick}>
                    <TextField id="outlined-basic" label="Login" onChange={this.loginInputChangeHandler}></TextField>
                    <br></br>
                    <TextField id="outlined-basic" label="Password" type="password" onChange={this.passwordInputChangeHandler}></TextField>
                    <br></br>
                    <TextField id="outlined-basic" label="Name" onChange={this.nameInputChangeHandler}></TextField>
                    <br></br>
                    <TextField id="outlined-basic" label="Email" onChange={this.emailInputChangeHandler}></TextField>
                    <br></br>
                    <TextField id="outlined-basic" label="Description" onChange={this.descriptionInputChangeHandler}></TextField>
                    <br></br>
                    <TextField id="outlined-basic" label="City" onChange={this.cityInputChangeHandler}></TextField>
                    <br></br>
                    <TextField id="outlined-basic" label="Picture" onChange={this.pictureInputChangeHandler}></TextField>
                    <br></br>
                    <TextField id="outlined-basic" label="Year" onChange={this.yearInputChangeHandler}></TextField>
                    <br></br>
                    <TextField id="outlined-basic" label="Weight" onChange={this.weightInputChangeHandler}></TextField>
                    <br></br>
                    <Button className="loginButton" type="submit" variant="contained" color="primary" >Register</Button>
                    <Button className="loginButton" variant="contained" color="primary"
                            onClick={this.props.handleRegister}>Login</Button>
                </form>
                </div>
        )
    }
}

export default Login;