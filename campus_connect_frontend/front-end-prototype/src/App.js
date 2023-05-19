import ChatBox from "./Components/ChatBox";
import Messages from "./Components/Messages";

function App() {
  return (
    <div className="flex flex-row w-full h-screen">
      <Messages />
      <ChatBox />
    </div>
  );
}

export default App;
