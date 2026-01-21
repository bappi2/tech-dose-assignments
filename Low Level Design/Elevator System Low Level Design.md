Low-Level Design

Design Elevator System

Clarifying Questions
You: How many elevators and floors are we dealing with? Is this configurable or fixed?"

You: When someone on a floor calls an elevator, 
    is it a simple up/down hall call or 
    a destination dispatch panel where they pick a floor and get assigned a car? 
    Either way, how should the system decide which elevator to send?
Interviewer: "Keep it simple: classic up/down hall calls. 
The system should pick an elevator intelligently, but we can start with something straightforward."

You: Once someone is inside an elevator, how do they select floors? 
Can they select multiple destinations?

You: "Should we distinguish between different types of stops? 
Like someone on a floor calling the elevator up versus down, 
versus someone inside selecting a destination?"
Interviewer: "Good thinking. Yes, hall calls should specify direction. 
Destination buttons inside don't have a direction - just stop there."

You: "What about invalid requests? Should we handle things like 
requesting a floor that doesn't exist, or someone pressing the button for the floor they're already on?"

Requirements:
1. System manages 3 elevators serving 10 floors (0-9)
2. Users can request an elevator from any floor (hall call). System decides which elevator to dispatch.
3. Once inside, users can select one or more destination floors
4. Simulation runs in discrete time steps (e.g., a `step()` or `tick()` call advances time)
5. Elevator stops come in two types:
    - Hall calls: Request from a floor with direction (UP or DOWN)
    - Destination: Request from inside elevator (no direction specified)
6. System handles multiple concurrent pickup requests across floors
7. Invalid requests should be rejected (return false)
    - Non-existent floor numbers
8. Requests for the current floor are treated as a no-op / already served (doors out of scope)

Out of scope:
- Weight capacity and passenger limits
- Door open/close mechanics
- Emergency stop functionality
- Dynamic floor/elevator configuration
- UI/rendering layer