import React, { Component } from 'react';
import Ranking from './rank';
import NavigationBar from './navigationBar';
import MainContent from './mainContent';
import FindFriend from './friends';
import Info from './info'
import Gymder from './gymder';
import Goals from './goals';

class MainComponent extends Component {
    state = {
        contextDict: {
            "Friends": <FindFriend />,
            "Info": <Info />,
            "Gymder": <Gymder />,
            "Goals": <Goals />
        },
        contextName: "Info",
        context: <Info />
    }

    mapContext = (contextName) => {

    }

    handleContextChange = (contextName) => {
        console.log("context change");
        const context = this.state.contextDict[contextName];
        this.setState({ context });
        console.log(this.state.context);
    }
    render() {
        return (
            <div >
                <MainContent context={this.state.context} />
                <NavigationBar handleContextChange={this.handleContextChange} />
                <Ranking />
            </div >);
    }
}

export default MainComponent;