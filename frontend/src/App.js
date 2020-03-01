import React from 'react';
import './App.css';
import Ranking from './components/rank';
import NavigationBar from './components/navigationBar';
import MainContent from './components/mainContent';
import MainComponent from './components/mainComponent';

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            user: {}
        };
    }

    handleLogin = (user) => {
        console.log('Handle login called in App.js, user: ', user)
        this.setState({ user: user })
    }

    handleLogout() {
        this.setState({ user: {} })
    }

    render() {
        return (
            <MainComponent userContext={{
                user: this.state.user,
                handleLogin: this.handleLogin,
                handleLogout: this.handleLogout
            }}
            />
        );
    };
}

export default App;
