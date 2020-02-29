import React, { Component } from 'react';
import '../styles/rank.css';

class Ranking extends Component {
    state = {
        users: [
            { id: 1, username: "Mike Oxlong", points: 1486 },
            { id: 2, username: "Haywood Jablowme", points: 1456 },
            { id: 3, username: "Craivn Morehead", points: 1337 },
            { id: 4, username: "Ben Dover", points: 1278 }]
    }

    render() {
        return (<div className="rankMainDiv"><ol>
            {this.state.users.map(user => <li key={user.id} className="rankListItem">{user.username}: {user.points}</li>)}
        </ol>
        </div >);
    }
}

export default Ranking;