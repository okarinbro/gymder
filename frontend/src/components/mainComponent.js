import React, {Component} from 'react';
import Ranking from './rank';
import NavigationBar from './navigationBar';
import MainContent from './mainContent';
import FindFriend from './friends';
import Info from './info'
import Gymder from './gymder';
import Goals from './goals';
import Day from './day';

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

    getData() {
        // create a new XMLHttpRequest
        var xhr = new XMLHttpRequest()

        // get a callback when the server responds
        xhr.addEventListener('load', () => {
            // update the state of the component with the result here
            console.log(xhr.responseText)
        })
        // open the request with the verb and the url
        xhr.open('GET', 'http://localhost:8080/api/user/friends/?id=1')
        // send the request
        xhr.send()
        console.log(xhr);
    }
    render() {

        return (<div >
            <MainContent context={this.state.context} />
            <NavigationBar handleContextChange={this.handleContextChange} />
            <Ranking />
            <button onClick={this.getData}>Get</button>
        </div >);

    }
}

export default MainComponent;