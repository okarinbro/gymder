import React, {Component} from 'react';
import '../styles/gymder.css'
import Button from '@material-ui/core/Button';


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
            this.setState({users: response.data})
            console.log({state: this.state})
        })
    }


    render() {
        return (
            this.state.users.length > 0 ?
                <div className="gymderMainDiv">
                    <img src={this.state.users[this.state.index].pictureLink} width="350" height="350"/>
                    <div className="gymderDescriptionDiv">{this.state.users[this.state.index].name}</div>
                    <div style={{height: "50px"}}> {this.state.users[this.state.index].description} </div>
                    <div>
                        <Button variant="outlined" className="gymderSideButton"
                                onClick={this.decrementIndex}>Previous</Button>
                        <Button variant="outlined" className="gymderCentralButton" onClick={this.invite}>Invite</Button>
                        <Button variant="outlined" className="gymderSideButton"
                                onClick={this.incrementIndex}>Next</Button>
                    </div>

                </div> : <div></div>);

    }
}

export default Gymder;