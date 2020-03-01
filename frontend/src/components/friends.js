import React, {Component} from 'react';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';

const axios = require("axios").default;

class Friends extends Component {
    state = {
        users: [],
        invitations: [],
        friendUsername: ''
    }

    componentWillMount() {
        axios.get("http://localhost:8080/api/user/friends/?id=201").then(
            (response) => {
                this.setState({users: response.data})
                console.log(this.state.users)
            }
        ).catch((error) => {
            console.log(error)
        });
        axios.get("http://localhost:8080/api/invitation/?id=201").then(
            (response) => {
                this.setState({invitations: response.data})
                console.log(this.state.invitations)
            }
        ).catch((error) => {
            console.log(error)
        })
    }

    usernameInputChangeHandler = (event) => {
        this.setState({friendUsername: event.target.value})
    }

    sendFriendRequestButtonHandler = () => {
        axios.post('http://localhost:8080/api/friendship/?firstUser=201&secondUser=' + this.state.friendUsername)
            .then(response => console.log(response))
            .catch(error => console.log(error))
    }

    acceptInvitation = (id) => {
        console.log(this.state.invitations)
        let invitation = this.state.invitations.filter(c => c.sender.id !== id);
        const invitations = this.state.invitations.map(inv => inv.sender.id !== id ? inv : invitation);
        this.setState({invitations});
        console.log(this.state.invitations)
        // axios.post('http://localhost:8080/api/friendship/?firstUser=201&secondUser=' + this.state.friendUsername)
        //     .then(response => console.log(response))
        //     .catch(error => console.log(error))
    }

    render() {
        return (<div><h3>Friends</h3>
            <ul style={{listStyle: "none"}}>{this.state.users.map(user => <li
                key={user.id}>{user.name} - {user.email}</li>)}</ul>
            <form>
                <TextField id="outlined-basic" label="Friend's username" variant="outlined"
                           onChange={this.usernameInputChangeHandler}></TextField><br></br>
                <Button style={{marginTop: "3px"}} variant="contained" color="primary"
                        onClick={this.sendFriendRequestButtonHandler}>Send friend
                request</Button>
            </form>
            <h3 style={{marginBottom: "3px", marginTop: "30px"}}>Invitations</h3>
            <ul style={{listStyle: "none"}}>{this.state.invitations.map(user => <li
                    key={user.id}>{user.sender.name} - {user.sender.email} <Button variant="contained" color="primary"
                                                                                   onClick={() => this.acceptInvitation(user.sender.id)}>Accept</Button>
                </li>
            )}</ul>
        </div>);
    }
}

export default Friends;