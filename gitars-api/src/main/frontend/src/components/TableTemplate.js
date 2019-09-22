import React from 'react';
import { withStyles, makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
const StyledTableCell = withStyles(theme => ({
    head: {
        backgroundColor: theme.palette.common.black,
        color: theme.palette.common.white,
    },
    body: {
        fontSize: 14,
    },
}))(TableCell);

const StyledTableRow = withStyles(theme => ({
    root: {
        '&:nth-of-type(odd)': {
            backgroundColor: theme.palette.background.default,
        },
    },
}))(TableRow);


const useStyles = makeStyles(theme => ({
    root: {
        width: '80%',
        marginLeft:'10%',
        marginTop: theme.spacing(3),
        overflowX: 'auto',
    },
    table: {
        minWidth: 700,
    },
}));

export default function TableTemplate(props) {
    const classes = useStyles();

    return (
        <Paper className={classes.root}>

            <Table className={classes.table}>
                <TableHead>
                    <TableRow>
                        <StyledTableCell>Brand</StyledTableCell>
                        <StyledTableCell align="right">Id</StyledTableCell>
                        <StyledTableCell align="right">Model</StyledTableCell>
                        <StyledTableCell align="right">Strings</StyledTableCell>
                        <StyledTableCell align="right"></StyledTableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {props.gitarList.map(row => (
                        <StyledTableRow key={row.id}>
                            <StyledTableCell component="th" scope="row">{row.brand}</StyledTableCell>
                            <StyledTableCell align="right">{row.id}</StyledTableCell>
                            <StyledTableCell align="right">{row.model}</StyledTableCell>
                            <StyledTableCell align="right">{row.strings}</StyledTableCell>
                            <StyledTableCell align="right"><button className="btn-post" id={row.id} onClick={props.handleOpen}>read more</button></StyledTableCell>
                        </StyledTableRow>
                        ))}
                </TableBody>
            </Table>
        </Paper>
    );
}
