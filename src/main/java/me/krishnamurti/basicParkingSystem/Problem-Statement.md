**Title**: Smart Parking System with Payment Calculation

**Description**:

Design a car parking application to manage parking for two categories of vehicles: **SUVs** and **Hatchbacks**. The system must track the entry and exit of cars, maintain counts of parked SUVs and Hatchbacks, allocate parking slots based on availability, calculate parking fees, and provide an admin view of all parked cars. Parking rates are fixed: Hatchbacks cost **10 rupees per hour**, and SUVs cost **20 rupees per hour**. If Hatchback slots are full, Hatchbacks can park in SUV slots but still pay the Hatchback rate. Upon exit, the system must inform the user of their total payment based on parking duration.

**Requirements**:

1. **Parking Slots**:
    - The parking lot has a fixed number of slots designated for SUVs and Hatchbacks (e.g., `maxSUVSlots` and `maxHatchbackSlots`).
    - Hatchbacks can occupy SUV slots if Hatchback slots are full, but SUVs cannot occupy Hatchback slots.
2. **Entry**:
    - Record a car’s entry with its type (SUV or Hatchback), a unique identifier (e.g., license plate), and entry timestamp.
    - Update the count of parked SUVs and Hatchbacks.
    - Assign a slot (Hatchback slot, or SUV slot if Hatchback slots are full).
3. **Exit**:
    - Record a car’s exit with its unique identifier and exit timestamp.
    - Calculate the parking duration (in hours, rounded up to the nearest hour).
    - Compute the payment:
        - Hatchback: 10 rupees/hour (even if parked in an SUV slot).
        - SUV: 20 rupees/hour.
    - Inform the user of the total payment.
    - Free the occupied slot and update the count.
4. **Admin View**:
    - Provide a function for the admin to see all currently parked cars, including their type, identifier, entry time, and assigned slot type.
5. **Tracking**:
    - Maintain real-time counts of parked SUVs and Hatchbacks.

**Input**:

- Initial setup: `maxSUVSlots` (integer), `maxHatchbackSlots` (integer).
- Commands:
    - `enter(type, carId, entryTime)`: Car enters with type ("SUV" or "Hatchback"), unique `carId` (string), and `entryTime` (timestamp in hours, e.g., integer).
    - `exit(carId, exitTime)`: Car exits with `carId` and `exitTime` (timestamp in hours).
    - `getAdminView()`: Returns list of all parked cars.
    - `getCounts()`: Returns current counts of parked SUVs and Hatchbacks.

**Output**:

- `enter`: Boolean (true if parked successfully, false if no slots available).
- `exit`: Integer (total payment in rupees).
- `getAdminView`: List of parked cars with details (e.g., `[{carId, type, entryTime, slotType}]`).
- `getCounts`: Tuple or object (e.g., `{suvCount, hatchbackCount}`).

**Constraints**:

- 1 ≤ `maxSUVSlots`, `maxHatchbackSlots` ≤ 1000
- `carId` is a unique string (e.g., "ABC123").
- 0 ≤ `entryTime` < `exitTime` ≤ 10^6 (timestamps in hours).
- Parking duration is calculated as `ceil(exitTime - entryTime)` hours.

**Examples**:

1. **Setup**: `maxSUVSlots = 2`, `maxHatchbackSlots = 2`
    - `enter("Hatchback", "H1", 1)` → true (Hatchback slot used, counts: SUV=0, Hatchback=1)
    - `enter("SUV", "S1", 2)` → true (SUV slot used, counts: SUV=1, Hatchback=1)
    - `enter("Hatchback", "H2", 3)` → true (Hatchback slot used, counts: SUV=1, Hatchback=2)
    - `enter("Hatchback", "H3", 4)` → true (SUV slot used, counts: SUV=1, Hatchback=3)
    - `exit("H1", 5)` → 40 (4 hours * 10 = 40 rupees)
    - `getAdminView()` → `[{carId: "S1", type: "SUV", entryTime: 2, slotType: "SUV"}, {carId: "H2", type: "Hatchback", entryTime: 3, slotType: "Hatchback"}, {carId: "H3", type: "Hatchback", entryTime: 4, slotType: "SUV"}]`
2. **Setup**: `maxSUVSlots = 1`, `maxHatchbackSlots = 1`
    - `enter("SUV", "S1", 0)` → true
    - `enter("Hatchback", "H1", 1)` → true
    - `enter("SUV", "S2", 2)` → false (no SUV slots available)
    - `exit("S1", 3)` → 60 (3 hours * 20 = 60 rupees)