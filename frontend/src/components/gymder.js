import React, { Component } from 'react';
import '../styles/gymder.css'

class Gymder extends Component {
    state = {
        users: [
            { id: 1, name: "Okarinbro", description: "Big boii", img_src: "https://www.monedo.pl/now/blog/wp-content/uploads/2019/07/gory-na-weekend-w-lipcu-i-sierpniu-2019-750x393.jpg" },
            { id: 2, name: "Shomrey", description: "Best boii", img_src: "https://images.pexels.com/photos/20787/pexels-photo.jpg?auto=compress&cs=tinysrgb&h=350" },
            { id: 3, name: "Meehaw", description: "Nice boii", img_src: "https://www.monedo.pl/now/blog/wp-content/uploads/2019/07/gory-na-weekend-w-lipcu-i-sierpniu-2019-750x393.jpg" },
            { id: 4, name: "Mervolt", description: "Good boii", img_src: "https://images.pexels.com/photos/20787/pexels-photo.jpg?auto=compress&cs=tinysrgb&h=350" }
        ],
        index: 0
    }

    decrementIndex = () => {
        const index = (this.state.index == 0 ? this.state.users.length - 1 : this.state.index - 1);
        this.setState({ index });
    }
    incrementIndex = () => {
        const index = (this.state.index == this.state.users.length - 1 ? 0 : this.state.index + 1);
        this.setState({ index });
    }
    invite = () => {
        console.log("TODO implement invitation");
    }
    render() {
        return (<div className="gymderMainDiv">
            <img src={this.state.users[this.state.index].img_src} width="200" height="100" />
            <div className="gymderDescriptionDiv">{this.state.users[this.state.index].name}</div>
            <div> {this.state.users[this.state.index].description} </div>
            <div >
                <button className="gymderSideButton" onClick={this.decrementIndex}>Previous</button>
                <button className="gymderCentralButton" onClick={this.invite}>Invite</button>
                <button className="gymderSideButton" onClick={this.incrementIndex}>Next</button>
            </div>

        </div>);
    }
}

export default Gymder;