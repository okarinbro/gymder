import React, { Component } from 'react';

class Login extends Component {
    state = {
        login: '',
        password: ''
    }

    loginButtonOnClick() {
        const userData = {
            login: this.state.login,
            password: this.state.password
        }

        console.log(userData)
        /* TODO: send POST request to login controller API and if user 
           has successfully log on, notify App component */
    }

    loginInputChangeHandler = (event) => {
        this.setState({login: event.target.value})
    }

    passwordInputChangeHandler = (event) => {
        this.setState({password: event.target.value})
    }

    render() {
        return (
            <div>
                <form action="/action_page.php">
                    <label for="login">Login</label>
                    <input type="text" id="login" name="login" onChange={this.loginInputChangeHandler} />
                    <br></br>
                    <label for="password">Last name:</label>
                    <input type="text" id="password" name="password" onChange={this.passwordInputChangeHandler} />
                    <br></br>
                    <button onClick={this.loginButtonOnClick}> Log in! </button>
                </form>
            </div>
        )
    }
}

export default Login;