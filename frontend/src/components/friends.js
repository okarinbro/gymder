import React, { Component } from 'react';

class Friends extends Component {
    state = {
        users: [
            { id: 1, name: "Okarinbro", describtion: "Big boii", mail: "bikduyck@gmail.com" },
            { id: 2, name: "Shomrey", describtion: "Best boii", mail: "ewenbeger@gmail.com" },
            { id: 3, name: "Meehaw", describtion: "Nice boii", mail: "btsmlr@gmail.com" },
            { id: 4, name: "Mervolt", describtion: "Good boii", mail: "ewenmor@gmail.com" }
        ]
    }

    render() {
        return (<div><ul>{this.state.users.map(user => <li key={user.id}>{user.name} - {user.mail}</li>)}</ul></div>);
    }
}

export default Friends;