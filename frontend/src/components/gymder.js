import React, {Component} from 'react';
import '../styles/gymder.css'

class Gymder extends Component {
    state = {
        users: [
            {id: 1, name: "Przemysław Jabłecki", description: "Big boii", img_src: "https://i.imgur.com/wjNUctu.jpg"},
            {id: 2, name: "Michał Przybycień", description: "Best boii", img_src: "https://i.imgur.com/JHQ7af4.jpg"},
            {id: 3, name: "Michał Komar", description: "Nice boii", img_src: "https://i.imgur.com/tfDu50I.jpg"},
            {id: 4, name: "Michał Maksoń", description: "Good boii", img_src: "https://i.imgur.com/SjdwbgA.jpg"}
        ],
        index: 0
    }

    decrementIndex = () => {
        const index = (this.state.index === 0 ? this.state.users.length - 1 : this.state.index - 1);
        this.setState({index});
    }
    incrementIndex = () => {
        const index = (this.state.index === this.state.users.length - 1 ? 0 : this.state.index + 1);
        this.setState({index});
    }
    invite = () => {
        console.log("TODO implement invitation");
    }

    render() {
        return (<div className="gymderMainDiv">
            <img src={this.state.users[this.state.index].img_src} top="10" width="300" height="300"/>
            <div className="gymderDescriptionDiv">{this.state.users[this.state.index].name}</div>
            <div> {this.state.users[this.state.index].description} </div>
            <div>
                <button className="gymderSideButton" onClick={this.decrementIndex}>Previous</button>
                <button className="gymderCentralButton" onClick={this.invite}>Invite</button>
                <button className="gymderSideButton" onClick={this.incrementIndex}>Next</button>
            </div>

        </div>);
    }
}

export default Gymder;