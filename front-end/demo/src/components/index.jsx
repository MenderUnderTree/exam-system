import React, { Component } from 'react';
import { HashRouter, Switch, Route, Redirect } from 'react-router-dom';

import PaperList from './PaperList/index';
import PaperContent from './PaperContent/index';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {};
    }

    componentDidMount () {
        console.log(1)
    }

    render() {
        return (
            <section>
                <header className="App-header">
                    <h1 className="App-title">555 <span>做更好的自己</span></h1>
                    <div className="App-user">
                        <span>张同学</span>
                    </div>
                </header>
                <section className="App-content">
                    <HashRouter basename="/" >
                        <Switch>
                            <Route path="/paperlist" exact component={PaperList}></Route>
                            <Route path="/papercontent/:id" exact component={PaperContent}></Route>
                            <Redirect to="/" />
                        </Switch>
                    </HashRouter>
                </section>

            </section>

        );
    }
}

export default App;