import './App.css';

function App() {

  const office = {
    name: "Sky Tower",
    rent: 55000,
    address: "Chennai"
  };

  const offices = [
    {
      name: "Sky Tower",
      rent: 55000,
      address: "Chennai"
    },
    {
      name: "Tech Park",
      rent: 75000,
      address: "Bangalore"
    },
    {
      name: "Business Hub",
      rent: 45000,
      address: "Hyderabad"
    }
  ];

  return (
    <div className="App">

      <h1>Office Space Rental App</h1>

      <img
        src="https://images.unsplash.com/photo-1497366754035-f200968a6e72?w=800"
        alt="Office"
        width="500"
      />

      <h2>Featured Office</h2>

      <p><strong>Name:</strong> {office.name}</p>

      <p
        style={{
          color: office.rent < 60000 ? "red" : "green"
        }}
      >
        <strong>Rent:</strong> ₹{office.rent}
      </p>

      <p><strong>Address:</strong> {office.address}</p>

      <hr />

      <h2>Available Offices</h2>

      {
        offices.map((item, index) => (

          <div key={index} className="card">

            <h3>{item.name}</h3>

            <p
              style={{
                color: item.rent < 60000 ? "red" : "green"
              }}
            >
              Rent: ₹{item.rent}
            </p>

            <p>Address: {item.address}</p>

          </div>

        ))
      }

    </div>
  );
}

export default App;