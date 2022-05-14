import { Checkbox, TableCell, TableRow } from "@mui/material";

const SubjectRow = (props) => {

    const row = props.data;

    const handleClick = (event, id) => {
        console.log(event);
        console.log(id);
    };

    return (
        <TableRow
            hover
            onClick={(event) => handleClick(event, row.id)}
            role="checkbox"
            key={row.id}
        >
            <TableCell padding="checkbox">
                <Checkbox
                    color="primary"
                    inputProps={{
                        'aria-labelledby': row.id,
                    }}
                />
            </TableCell>
            <TableCell
                component="th"
                id={row.id}
                scope="row"
                padding="normal"
            >
                {row.firstname}
            </TableCell>
            <TableCell>{row.lastname}</TableCell>
            <TableCell>{row.age}</TableCell>
            <TableCell>{row.orientation}</TableCell>
            <TableCell>{row.hospitalId}</TableCell>
            <TableCell>{row.groupId}</TableCell>
        </TableRow>
    );

};

export default SubjectRow;