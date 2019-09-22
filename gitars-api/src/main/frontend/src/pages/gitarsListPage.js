import React,{Component} from 'react';
import axios from "axios";
import TableTemplate from "../components/TableTemplate";
import Button from "@material-ui/core/Button";
import '../App.css';
import TextField from 'material-ui/TextField';
import FormControl from '@material-ui/core/FormControl';

/**
 * @description gitarListPAGE Modal for show list details
 * @param {*} props
 */
const SelectedRowModal = props => {
    return (
        <div className={props.show === true? "modal display-block" : "modal display-none"} style={{zIndex: "10000"}}>
            {(props.selectedGitar.id) ?
                <section className="modal-main" style={{textAlign:"center"}}>
                    <FormControl margin="normal" required fullWidth  style={{textAlign:"center"}}>
                        <h4>Model of Gitar: </h4>
                        <TextField data-id="title" style={{textAlign:"center", paddingLeft:"5px"}} autoFocus
                                   onChange={props.onChangeModel} value={props.selectedGitar.model} placeholder={props.selectedGitar.model}
                                   floatingLabelText="Title"
                        />
                    </FormControl>
                    <FormControl margin="normal" required fullWidth  style={{textAlign:"center", paddingLeft:"5px"}}>
                        <h4>Identifier:</h4>
                        <TextField data-id="subtitle"
                                   onChange={props.onChangeModel} value={props.selectedGitar.id} placeholder={props.selectedGitar.id}
                                   floatingLabelText="Subtitle"
                        />
                    </FormControl>
                    <FormControl margin="normal" required fullWidth  style={{textAlign:"center", paddingLeft:"5px"}}>
                        <h4>Strings of Gitar:</h4>
                        <TextField data-id="subtitle"
                                   onChange={props.onChangeModel} value={props.selectedGitar.strings} placeholder={props.selectedGitar.strings}
                                   floatingLabelText="Subtitle"
                        />
                    </FormControl>
                    <FormControl margin="normal" required fullWidth  style={{textAlign:"center", paddingLeft:"5px"}}>
                        <h4>Brand of Gitar:</h4>
                        <TextField data-id="subtitle"
                                   onChange={props.onChangeModel} value={props.selectedGitar.brand} placeholder={props.selectedGitar.brand}
                                   floatingLabelText="Subtitle"
                        />
                    </FormControl>
                    <Button onClick={props.handleClose} variant="contained" color="secondary">close</Button>
                    <button className="btn-update" variant="contained" color="secondary" data-id={props.selectedGitar.id} value="update" onClick={props.handleUpdatePost}>UPDATE</button>
                </section>:console.log("There is not currect information please call support team.")

            }
        </div>
    );
};

/**
 * @description gitarPage:
 */
class gitarsListPage extends Component {

    state = {
        gitarlist:[],
        selectedGitar:{},
        open:false
    }

    componentWillMount() {
        axios.get("/gitars").then(result => {
                    this.setState(prevState => ({
                gitarlist: prevState.gitarlist.concat(result.data)
            }));
        });
    }

    /**
     * @description open modal to show post
     */
    handleOpen = (event) => {
        event.preventDefault();
        let gitarId = event.target.id;
        const selected = this.state.gitarlist.filter(e => e.id == gitarId);
        this.setState({selectedGitar: selected[0], open: true });
    };

    /**
     * @description close moda
     */
    handleClose = () => {
        this.setState({ selectedGitar: {},open: false });
    };

    render() {
        return (
            <div className="home">
                <h3>gitarlist:</h3>
                <TableTemplate gitarList={this.state.gitarlist} show={this.state.open}  handleOpen={this.handleOpen} selectedGitar={this.state.selectedGitar}/>
                <SelectedRowModal show={this.state.open} handleOpen={this.handleOpen} handleClose={this.handleClose} selectedGitar={this.state.selectedGitar}/>
            </div>)
    }
};

export default gitarsListPage;
