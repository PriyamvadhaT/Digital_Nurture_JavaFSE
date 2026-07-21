import React from "react";
import FlightDetails from "./FlightDetails";

function GuestPage() {
  return (
    <div>
      <h2>Welcome Guest!</h2>

      <FlightDetails />

      <p>Please login to book tickets.</p>
    </div>
  );
}

export default GuestPage;