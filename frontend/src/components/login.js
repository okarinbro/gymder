import React, { Component } from 'react';

class Login extends Component {
    state = {
        login: '',
        password: ''
    }

    loginButtonOnClick = (event) => {
        const userData = {
            login: this.state.login,
            password: this.state.password
        }

        console.log(userData);
        event.preventDefault();
        console.log(this.props);
        this.props.handleLogin();
        console.log("should run change");

        /* TODO: send POST request to login controller API and if user 
           has successfully log on, notify App component */
    }

    loginInputChangeHandler = (event) => {
        this.setState({ login: event.target.value })
    }

    passwordInputChangeHandler = (event) => {
        this.setState({ password: event.target.value })
    }

    render() {
        return (
            <div>
                <form onSubmit={this.loginButtonOnClick}>
                    <label for="login">Login</label>
                    <input type="text" id="login" name="login" onChange={this.loginInputChangeHandler} />
                    <br></br>
                    <label for="password">Last name:</label>
                    <input type="text" id="password" name="password" onChange={this.passwordInputChangeHandler} />
                    <br></br>
                    <input type="submit" value="Login" />
                </form>
            </div>
        )
    }
}

export default Login;