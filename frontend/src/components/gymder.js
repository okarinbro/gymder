import React, { Component } from 'react';
import '../styles/gymder.css'

class Gymder extends Component {
    state = {
        users: [
            { id: 1, name: "Okarinbro", description: "Big boii" },
            { id: 2, name: "Shomrey", description: "Best boii" },
            { id: 3, name: "Meehaw", description: "Nice boii" },
            { id: 4, name: "Mervolt", description: "Good boii" }
        ],
        index: 0
    }

    decrementIndex = () => {
        const index = (this.state.index === 0 ? this.state.users.length - 1 : this.state.index - 1);
        this.setState({ index });
    }
    incrementIndex = () => {
        const index = (this.state.index === this.state.users.length - 1 ? 0 : this.state.index + 1);
        this.setState({ index });
    }
    invite = () => {
        console.log("TODO implement invitation");
    }
    render() {
        return (<div className="gymderMainDiv">
            <div className="gymderDescribtionDiv">{this.state.users[this.state.index].name}</div>
            <div >
                <button className="gymderSideButton" onClick={this.decrementIndex}>Previous</button>
                <button className="gymderCentralButton" onClick={this.invite}>Invite</button>
                <button className="gymderSideButton" onClick={this.incrementIndex}>Next</button>
            </div>

        </div>);
    }
}

export default Gymder;