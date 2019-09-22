import React, { Component } from 'react';
import './App.css';
import getMuiTheme from 'material-ui/styles/getMuiTheme';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import {BrowserRouter as Router,Route, Switch} from 'react-router-dom';
import HomePage from './pages/homePage';
import GitarsListPage from './pages/gitarsListPage';

class App extends Component{
       render() {
        return(
            <MuiThemeProvider muiTheme={getMuiTheme()}>
                <Router>
                    <div>
                        <Switch>
                            <Route exact path="/" component={HomePage}/>
                            <Route path="/gitar" component={GitarsListPage}/>
                        </Switch>
                    </div>

                </Router>
            </MuiThemeProvider>
        )
    }
}
export default App;