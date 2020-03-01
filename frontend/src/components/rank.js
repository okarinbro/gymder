import React, {Component} from 'react';
import '../styles/rank.css';

const axios = require("axios")

class Ranking extends Component {
    state = {
        users: [
            // {id: 1, username: "Michał Przybycień", points: 1486},
            // {id: 2, username: "Michał Maksoń", points: 1456},
            // {id: 3, username: "Michał Komar", points: 1337},
            // {id: 4, username: "Przemysław Jabłecki", points: 1278}
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
        return (<div className="rankMainDiv">
            <h3 style={{marginLeft: "50px", fontSize: "25px"}}> Friend's rank </h3>
            <ol>
                {this.state.users.map(user => <li key={user.id}
                                                  className="rankListItem">{user.name}: {user.points}</li>)}
            </ol>
        </div>);
    }
}

export default Ranking;