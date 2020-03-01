import React, { Component } from 'react';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';

const axios = require("axios").default;

class Friends extends Component {
    state = {
        users: [
            // {id: 1, name: "Przemysław Jabłecki", describtion: "Big boii", mail: "bikduyck@gmail.com"},
            // {id: 2, name: "Michał Przybycień", describtion: "Best boii", mail: "ewenbeger@gmail.com"},
            // {id: 3, name: "Michał Komar", describtion: "Nice boii", mail: "btsmlr@gmail.com"},
            // {id: 4, name: "Michał Maksoń", describtion: "Good boii", mail: "ewenmor@gmail.com"}
        ],
        friendUsername: ''
    }

    componentWillMount() {
        axios.get("http://localhost:8080/api/user/friends/?id=201").then(
            (response) => {
                this.setState({ users: response.data })
                console.log(this.state.users)
            }
        ).catch((error) => {
            console.log(error)
        })
    }

    usernameInputChangeHandler(event) {
        this.setState({friendUsername: event.target.value})
    }

    sendFriendRequestButtonHandler() {
        axios.post('http://localhost:8080/api/friendship/?firstUser=201&secondUser=' + this.state.friendUsername)
        .then(response => console.log(response))
        .catch(error => console.log(error))
    }

    render() {
        return (<div>
            <ul>{this.state.users.map(user => <li key={user.id}>{user.name} - {user.email}</li>)}</ul>
            <TextField id="outlined-basic" label="Friend's username" variant="outlined"
                onChange={this.usernameInputChangeHandler}></TextField>
            <Button variant="contained" color="primary" >Send friend request</Button>

        </div>);
    }
}

export default Friends;