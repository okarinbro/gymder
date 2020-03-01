import React, {Component} from 'react';

const axios = require("axios");

class Friends extends Component {
    state = {
        users: [
            // {id: 1, name: "Przemysław Jabłecki", describtion: "Big boii", mail: "bikduyck@gmail.com"},
            // {id: 2, name: "Michał Przybycień", describtion: "Best boii", mail: "ewenbeger@gmail.com"},
            // {id: 3, name: "Michał Komar", describtion: "Nice boii", mail: "btsmlr@gmail.com"},
            // {id: 4, name: "Michał Maksoń", describtion: "Good boii", mail: "ewenmor@gmail.com"}
        ]
    }

    componentWillMount() {
        axios.get("http://localhost:8080/api/user/friends/?id=201").then(
            (response) => {
                this.setState({users: response.data})
                console.log(this.state.users)
            }
        ).catch((error) => {
            console.log(error)
        })
    }
    render() {
        return (<div>
            <ul>{this.state.users.map(user => <li key={user.id}>{user.name} - {user.email}</li>)}</ul>
        </div>);
    }
}

export default Friends;