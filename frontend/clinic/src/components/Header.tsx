import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {faStethoscope } from "@fortawesome/free-solid-svg-icons"


export default function Header() {
  return (
    <header className="header">
      <div className="container">
        <a href="/" className="link">
          <FontAwesomeIcon icon={faStethoscope } className="fa-icon" />
          <span className="brand-title">Clinic</span>
        </a>
        <nav className="nav">
          <ul>
            <li>
              <a href="/" className="navLink">
                Home
              </a>
            </li>
            <li>
              <a href="/about" className="navLink">
                About
              </a>
            </li>
            <li>
              <a href="/contact" className="navLink">
                Contact
              </a>
            </li>
            <li>
              <a href="/login" className="navLink">
                Login
              </a>
            </li>
          </ul>
        </nav>
      </div>
    </header>
  );
}