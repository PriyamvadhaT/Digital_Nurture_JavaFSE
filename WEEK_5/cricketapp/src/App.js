import './App.css';
import ListofPlayers from "./Components/ListofPlayers";
import IndianPlayers from "./Components/IndianPlayers";

function App() {

    const flag = false;

    if (flag === true) {
        return <ListofPlayers />;
    } else {
        return <IndianPlayers />;
    }

}

export default App;