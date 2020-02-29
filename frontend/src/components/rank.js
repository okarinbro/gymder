import React, { Component } from 'react';
import '../styles/rank.css';

class Ranking extends Component {
    state = {
        users: [
            { username: "Mike Oxlong", points: 1486 },
            { username: "Haywood Jablowme", points: 1456 },
            { username: "Craivn Morehead", points: 1337 },
            { username: "Ben Dover", points: 1278 }]
    }

    render() {
        return (<div className="rankMainDiv"><ol>
            {this.state.users.map(user => <li className="rankListItem">{user.username}: {user.points}</li>)}
        </ol>
        </div >);
    }
}

export default Ranking;