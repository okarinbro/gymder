import React from 'react';
import './App.css';
import Ranking from './components/rank';
import NavigationBar from './components/navigationBar';
import MainContent from './components/mainContent';
import MainComponent from './components/mainComponent';
import { userContext } from './context/userContext';

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            user: 0
        };
    }

    handleLogin(user_id) {
        this.setState({user: user_id})
    }

    render() {
        return (
            <userContext.Provider value={this.state.user}>
                <MainComponent />
            </userContext.Provider>
        );
    };
}

export default App;
