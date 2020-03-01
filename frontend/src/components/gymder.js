import React, {Component} from 'react';
import '../styles/gymder.css'

const axios = require('axios').default;

class Gymder extends Component {
    constructor(props) {
        super(props)
        this.state = {
            users: [],
            index: 0
        }

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

    componentDidMount() {
        axios.get('http://localhost:8080/api/user/gymder/?id=201').then((response) => {
            console.log(response.data)
            this.setState({ users: response.data })
            console.log({state: this.state})
        })
    }


    render() {
        return (
            this.state.users.length > 0 ?
            <div className="gymderMainDiv">
                <img src={this.state.users[this.state.index].pictureLink} width="350" height="350"/>
                <div className="gymderDescriptionDiv">{this.state.users[this.state.index].name}</div>
                <div> {this.state.users[this.state.index].description} </div>
                <div >
                    <button className="gymderSideButton" onClick={this.decrementIndex}>Previous</button>
                    <button className="gymderCentralButton" onClick={this.invite}>Invite</button>
                    <button className="gymderSideButton" onClick={this.incrementIndex}>Next</button>
                </div>

        </div> : <div></div>);

    }
}

export default Gymder;