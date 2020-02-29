import React, { Component } from 'react';
import NavigationItem from './navigationItem';
import '../styles/navigationBar.css';

class NavigationBar extends Component {
    state = {
        items: [
            { id: 1, name: "Info" },
            { id: 2, name: "Your day" },
            { id: 3, name: "Goals" },
            { id: 4, name: "Friends" }
        ]
    }
    render() {
        return (<div className="navigationMainDiv">
            {this.state.items.map(item => <div><NavigationItem name={item.name} /></div>)}
        </div>);
    }
}

export default NavigationBar;