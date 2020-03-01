import React, { Component } from 'react';
import Ranking from './rank';
import NavigationBar from './navigationBar';
import MainContent from './mainContent';
import FindFriend from './friends';
import Info from './info'
import Gymder from './gymder';
import Goals from './goals';
import Day from './day';
import Login from './login';

import { createMuiTheme, ThemeProvider } from '@material-ui/core/styles';



const theme = createMuiTheme({
    palette: {
        primary: {
            main: '#c2185b'
        },
        secondary: {
            main: '#1e88e5',
        }
    },
    status: {
        danger: 'orange',
    },
});

class MainComponent extends Component {
    state = {
        contextDict: {
            "Friends": <FindFriend />,
            "Info": <Info />,
            "Gymder": <Gymder />,
            "Goals": <Goals />,
            "Your day": <Day />
        },
        contextName: "Info",
        context: <Info />,
        register: false,
        logged: false
    }

    mapContext = (contextName) => {

    }

    handleContextChange = (contextName) => {
        console.log("context change");
        const context = this.state.contextDict[contextName];
        const logged = this.state.logged + 1;
        this.setState({ logged });
        this.setState({ context });


        console.log(this.state.logged);
        console.log(this.state.context);
    }

    handleLoginAccepted = () => {
        console.log("should change");
        const logged = true;
        this.setState({ logged });
    }

    handleRegister = () => {
        const register = !this.state.register;
        console.log("handle register mainComponent");
        this.setState({ register });
    }
    logged = <div >
        <MainContent context={this.state.context} />
        <NavigationBar handleContextChange={this.handleContextChange} />
        <Ranking />
        <button onClick={this.getData}>Get</button>
    </div >;

    notLogged = <Login handleLogin={this.handleLoginAccepted} />;

    render() {
        return (
            this.state.logged ? <div >
                <ThemeProvider theme={theme}>
                    <MainContent context={this.state.context} handleContextChange={this.handleContextChange} />
                    <Ranking />
                </ThemeProvider>
            </div > :
                <ThemeProvider theme={theme}>
                    <Login handleLogin={this.handleLoginAccepted} register={this.state.register} handleRegister={this.handleRegister} />
                </ThemeProvider>

        )
    };
}
// <NavigationBar handleContextChange={this.handleContextChange} />
//

export default MainComponent;