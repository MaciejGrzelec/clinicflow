import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faHeartPulse } from "@fortawesome/free-solid-svg-icons";
import "./footer.css";

export default function Footer() {
  return (
    <footer className="footer">
      Built with
      <FontAwesomeIcon
        icon={faHeartPulse}
        className="footer-icon"
        aria-hidden="true"
      />
      by MG
    </footer>
  );
}